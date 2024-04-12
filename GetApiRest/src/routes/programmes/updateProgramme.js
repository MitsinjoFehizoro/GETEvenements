const { ValidationError } = require("sequelize");
const { Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.put("/get/programmes/:id", (req, res) => {
    Programme.findByPk(req.params.id)
      .then((programme) => {
        if (programme) {
          Programme.update(
            {
              description: req.body.description,
              debut: req.body.debut,
              fin: req.body.fin,
            },
            {
              where: { id: programme.id },
            }
          )
            .then((_) => {
              Programme.findByPk(programme.id).then((programme) => {
                programme.getReception().then((reception) => {
                  reception.getEvenement().then((evenement) => {
                    const message = "Modification avec succes d'une programme.";
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
              });
            })
            .catch((error) => {
              if (error instanceof ValidationError) {
                res.status(400).json({ message: error.message });
              } else {
                const message =
                  "Erreur de la modification d'une programme. Reessayer dans quelques instants.";
                res.status(500).json({ message });
              }
            });
        } else {
          const message =
            "Tentative de modification d'une programme non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la modification d'une programme. Reessayer dans quelques instants.";
        res.status(500).json({ message: message });
      });
  });
};
