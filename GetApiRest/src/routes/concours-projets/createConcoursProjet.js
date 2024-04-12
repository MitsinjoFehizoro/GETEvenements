const { ValidationError } = require("sequelize");
const { Evenement, ConcoursProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/concours-projets", (req, res) => {
    Evenement.create({
      title: req.body.title,
      lieu: req.body.lieu,
      date: req.body.date,
      description: req.body.description,
      url : req.body.url
    })
      .then((evenement) => {
        evenement
          .createConcoursProjet({
            jurry: req.body.jurry,
          })
          .then((concoursProjet) => {
            const message = "Ajout avec succes d'un concours de projet";
            res.json({
              message: message,
              data: {
                id: concoursProjet.id,
                title: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                description: evenement.description,
                url : evenement.url,
                createdAt: concoursProjet.date,
                updatedAt: concoursProjet.updatedAt,
                jurry: concoursProjet.jurry,
              },
            });
          })
          .catch((error) => {
            if (error instanceof ValidationError) {
              res.status(400).json({ message: error.message });
            } else {
              handleError_500(res);
            }
          });
      })
      .catch((error) => {
        const message =
          "Erreur de l'ajout d'une conference. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
