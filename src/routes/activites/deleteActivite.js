const { ValidationError } = require("sequelize");
const { Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/activites/:id", (req, res) => {
    Activite.findByPk(req.params.id)
      .then((activite) => {
        if (activite) {
          activite.getExcursion().then((excursion) => {
            excursion.getEvenement().then((evenement) => {
              Activite.destroy({ where: { id: activite.id } })
                .then((_) => {
                  const message = "Suppression avec success d'une activite.";
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
                })
                .catch((error) => {
                  const message =
                    "Erreur de la suppression d'une activite. Reessayer dans quelques instants.";
                  res.status(500).json({ message });
                });
            });
          });
        } else {
          const message =
            "Tentative de suppression d'une activite non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'une activite. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
