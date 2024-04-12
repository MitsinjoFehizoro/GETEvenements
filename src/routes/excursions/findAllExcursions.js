const { Evenement, Excursion, Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/excursions", (req, res) => {
    Excursion.findAll({ include: [Evenement, Activite] })
      .then((excursions) => {
        const message = "Recuperation avec succes de toutes les excursions.";
        const data = excursions.map((excursion) => ({
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
        }));
        res.json({
          message: message,
          data: data,
        });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les excursions. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
