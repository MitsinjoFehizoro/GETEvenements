const { ValidationError } = require("sequelize");
const { Activite } = require("../../db/sequelize");

module.exports = (app) => {
  app.put("/get/activites/:id", (req, res) => {
    Activite.findByPk(req.params.id)
      .then((activite) => {
        if (activite) {
          Activite.update(
            {
              title: req.body.title,
              description: req.body.description,
            },
            {
              where: { id: activite.id },
            }
          )
            .then((_) => {
              Activite.findByPk(activite.id).then((activite) => {
                activite.getExcursion().then((excursion) => {
                  excursion.getEvenement().then((evenement) => {
                    const message = "Modification avec success d'une activite.";
                    res.json({
                      message: message,
                      data: {
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
                  "Erreur de la modification d'une activite. Reessayer dans quelques instants.";
                res.status(500).json({ message });
              }
            });
        } else {
          const message =
            "Tentative de modification d'une activite non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la modification d'une activite. Reessayer dans quelques instants.";
        res.status(500).json({ message: message });
      });
  });
};
