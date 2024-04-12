const { ValidationError } = require("sequelize");
const { Excursion } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/activites", (req, res) => {
    Excursion.findByPk(req.body.excursionId)
      .then((excursion) => {
        if (excursion) {
          excursion
            .createActivite({
              title: req.body.title,
              description: req.body.description,
            })
            .then((activite) => {
              activite.getExcursion().then((excursion) => {
                excursion.getEvenement().then((evenement) => {
                  const message = "Ajout avec succes d'une activite.";
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
            })
            .catch((error) => {
                if (error instanceof ValidationError) {
                  res.status(400).json({ message: error.message });
                } else {
                  const message = "Erreur de l'ajout d'une activite.";
                  res.status(500).json({ message });
                }
              });
        } else {
          const message =
            "Tentative d'ajout d'une activite pour une excursion non trouvee. Reessayer avec un autre excursionId valide.";
          res.status(400).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de l'ajout d'une activite. Reessayer dans quelques instants.";
        res.status(500).json({ message: message });
      });
  });
};
