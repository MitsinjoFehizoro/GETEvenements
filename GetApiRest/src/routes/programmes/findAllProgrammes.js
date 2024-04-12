const { Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/programmes", (req, res) => {
    const data = [];
    Programme.findAll()
      .then(async (programmes) => {
        for (const programme of programmes) {
          await programme.getReception().then(async (reception) => {
            await reception.getEvenement().then((evenement) => {
              data.push({
                id: programme.id,
                description: programme.description,
                debut: programme.debut,
                fin: programme.fin,
                reception_title: evenement.title,
                reception_participation: reception.partitipation,
                lieu: evenement.lieu,
                date: evenement.date,
                reception_description: evenement.description,
                createdAt: programme.createdAt,
                updatedAt: programme.updatedAt,
              });
            });
          });
        }

        const message = "Recuperation avec succes de toutes les programmes.";
        res.json({
          message: message,
          data: data,
        });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les programmes. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
