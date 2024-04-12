const { ValidationError } = require("sequelize");
const { Evenement } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/receptions", (req, res) => {
    Evenement.create({
      title: req.body.title,
      lieu: req.body.lieu,
      date: req.body.date,
      description: req.body.description,
      url : req.body.url
    })
      .then((evenement) => {
        evenement
          .createReception({
            participation: req.body.participation,
          })
          .then((reception) => {
            const message = "Ajout avec succes d'une reception.";
            res.json({
              message: message,
              data: {
                id: reception.id,
                title: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                description: evenement.description,
                url : evenement.url,
                participation: reception.participation,
                createdAt: reception.createdAt,
                updatedAt: reception.updatedAt,
              },
            });
          });
      })
      .catch((error) => {
        if (error instanceof ValidationError) {
          res.status(400).json({ message: error.message });
        } else {
          const message =
            "Erreur de l'ajout d'une reception. Reessayer dans quelques instants.";
          res.status(500).json({ message });
        }
      });
  });
};
