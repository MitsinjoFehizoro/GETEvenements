const { Evenement, Reception, Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/receptions", (req, res) => {
    Reception.findAll({ include: [Evenement, Programme] }).then(
      (receptions) => {
        const message = "Recuperation avec succes de toutes les receptions.";
        const data = receptions.map((reception) => ({
          id: reception.id,
          title: reception.Evenement.title,
          lieu: reception.Evenement.lieu,
          date: reception.Evenement.date,
          description: reception.Evenement.description,
          url : reception.Evenement.url,
          createdAt: reception.createdAt,
          updatedAt: reception.updatedAt,
          participation: reception.participation,
          programmes: reception.Programmes,
        }));
        res.json({
          message: message,
          data: data,
        });
      }
    )
    .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les receptions. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
