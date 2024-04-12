const { Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/programmes/:id", (req, res) => {
    Programme.findByPk(req.params.id)
      .then((programme) => {
        if (programme) {
          programme.getReception().then((reception) => {
            reception.getEvenement().then((evenement) => {
              const message = "Recuperation avec succes d'une programme";
              res.json({
                message: message,
                data: {
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
                },
              });
            });
          });
        } else {
          const message = "Programme non trouvee. Veuillez verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'une programme. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
