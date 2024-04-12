const { Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/activites", (req, res) => {
    const data = [];
    Activite.findAll()
      .then(async (activites) => {
        for (const activite of activites) {
          await activite.getExcursion().then(async (excursion) => {
            await excursion.getEvenement().then((evenement) => {
              data.push({
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
              });
            });
          });
        }

        const message = "Recuperation avec succes de toutes les activites.";
        res.json({
          message: message,
          data: data,
        });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les activites. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
