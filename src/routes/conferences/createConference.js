const { ValidationError } = require("sequelize");
const { Evenement, Conference } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/conferences/", (req, res) => {
    Evenement.create({
      title: req.body.title,
      lieu: req.body.lieu,
      date: req.body.date,
      description: req.body.description,
      url : req.body.url
    })
      .then((evenement) => {
        evenement
          .createConference({
            intervenant: req.body.intervenant,
            cible: req.body.cible,
          })
          .then((conference) => {
            const message = "Ajout avec succes d'une conference.";
            res.json({
              message: message,
              data: {
                id: conference.id,
                title: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                description: evenement.description,
                createdAt: conference.createdAt,
                updatedAt: conference.updatedAt,
                intervenant: conference.intervenant,
                cible: conference.cible,
                url : evenement.url
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
          "Erreur de l'ajoiut d'une conference. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
