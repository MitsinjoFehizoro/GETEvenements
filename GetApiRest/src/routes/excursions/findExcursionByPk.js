const { Evenement, Excursion, Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/excursions/:id", (req, res) => {
    Excursion.findByPk(req.params.id, {
      include: [Evenement, Activite],
    })
      .then((excursion) => {
        if (excursion) {
          const message = "Recuperation avec succes d'une excursion.";
          res.json({
            message: message,
            data: {
              id: excursion.id,
              title: excursion.Evenement.title,
              lieu: excursion.Evenement.lieu,
              date: excursion.Evenement.date,
              description: excursion.Evenement.description,
              url : excursion.Evenement.url,
              createdAt: excursion.createdAt,
              updatedAt: excursion.updatedAt,
              participation: excursion.participation,
              activites: excursion.Activites,
            },
          });
        } else {
          const message = "Excursion non trouvee. Verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'une excursion. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
