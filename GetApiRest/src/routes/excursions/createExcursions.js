const { ValidationError } = require("sequelize");
const { Evenement } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/excursions", (req, res) => {
    Evenement.create({
      title: req.body.title,
      lieu: req.body.lieu,
      date: req.body.date,
      description: req.body.description,
      url : req.body.url
    })
      .then((evenement) => {
        evenement
          .createExcursion({
            participation: req.body.participation,
          })
          .then((excursion) => {
            const message = "Ajout avec succes d'une excursion.";
            res.json({
              message: message,
              data: {
                id: excursion.id,
                title: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                description: evenement.description,
                participation: excursion.participation,
                createdAt: excursion.createdAt,
                updatedAt: excursion.updatedAt,
              },
            });
          });
      })
      .catch((error) => {
        if (error instanceof ValidationError) {
          res.status(400).json({ message: error.message });
        } else {
          const message =
            "Erreur de l'ajout d'une excursion. Reessayer dans quelques instants.";
          res.status(500).json({ message });
        }
      });
  });
};
