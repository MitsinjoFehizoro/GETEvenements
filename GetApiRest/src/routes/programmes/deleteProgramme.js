const { ValidationError } = require("sequelize");
const { Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/programmes/:id", (req, res) => {
    Programme.findByPk(req.params.id)
      .then((programme) => {
        if (programme) {
          programme.getReception().then((reception) => {
            reception.getEvenement().then((evenement) => {
              Programme.destroy({ where: { id: programme.id } })
                .then((_) => {
                  const message = "Suppression avec succes d'une programme.";
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
                })
                .catch((error) => {
                  const message =
                    "Erreur de la suppression d'une programme. Reessayer dans quelques instants.";
                  res.status(500).json({ message });
                });
            });
          });
        } else {
          const message =
            "Tentative de suppression d'une programme non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'une programmme. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
