const { Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/activites/:id", (req, res) => {
    Activite.findByPk(req.params.id)
      .then((activite) => {
        if (activite) {
          activite.getExcursion().then((excursion) => {
            excursion.getEvenement().then((evenement) => {
              const message = "Recuperation avec succes d'une activite.";
              res.json({
                message: message,
                data: {
                  id: activite.id,
                  title: activite.title,
                  description: activite.description,
                  excursion_participation: excursion.participation,
                  excursion_title: evenement.title,
                  lieu: evenement.lieu,
                  date: evenement.date,
                  excursion_description: evenement.description,
                  createdAt: activite.createdAt,
                  updatedAt: activite.updatedAt,
                },
              });
            });
          });
        } else {
          const message = "Activite non trouvee. Veuillez verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'une activite. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
