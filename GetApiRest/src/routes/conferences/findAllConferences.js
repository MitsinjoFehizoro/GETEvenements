const { Evenement, Conference } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/conferences", (req, res) => {
    Conference.findAll({ include: Evenement })
      .then((conferences) => {
        const data = conferences.map((conference) => ({
          id: conference.id,
          title: conference.Evenement.title,
          lieu: conference.Evenement.lieu,
          date: conference.Evenement.date,
          description: conference.Evenement.description,
          url : conference.Evenement.url,
          createdAt: conference.createdAt,
          updatedAt: conference.updatedAt,
          intervenant: conference.intervenant,
          cible: conference.cible,
        }));
        const message = "Recuperation avec succes de toutes les conferences.";
        res.json({ message: message, data: data });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les conferences. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
