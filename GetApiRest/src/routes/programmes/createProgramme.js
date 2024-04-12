const { ValidationError } = require("sequelize");
const { Reception } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/programmes", (req, res) => {
    Reception.findByPk(req.body.receptionId)
      .then((reception) => {
        if (reception) {
          reception
            .createProgramme({
              description: req.body.description,
              debut: req.body.debut,
              fin: req.body.fin,
            })
            .then((programme) => {
              programme.getReception().then((reception) => {
                reception.getEvenement().then((evenement) => {
                  const message = "Ajout avec succes d'une programme.";
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
            })
            .catch((error) => {
              if (error instanceof ValidationError) {
                res.status(400).json({ message: error.message });
              } else {
                const message = "Erreur de l'ajout d'une activite.";
                res.status(500).json({ message });
              }
            });
        } else {
          const message =
            "Tentative d'ajout d'une programme pour une reception non trouvee. Reessayer avec un autre excursionId valide.";
          res.status(400).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de l'ajout d'une programme. Reessayer dans quelques instants.";
        res.status(500).json({ message: message });
      });
  });
};
