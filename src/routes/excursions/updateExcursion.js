const { ValidationError } = require("sequelize");
const { Evenement, Excursion } = require("../../db/sequelize");

const handleError = (error, res) => {
  if (error instanceof ValidationError) {
    res.status(400).json({ message: error.message });
  } else {
    const message =
      "Erreur de la modification d'une excursion. Reessayer dans quelques instants.";
    res.status(500).json({ message });
  }
};

module.exports = (app) => {
  app.put("/get/excursions/:id", (req, res) => {
    Excursion.findByPk(req.params.id, { include: Evenement })
      .then((excursion) => {
        if (excursion) {
          Excursion.update(
            {
              participation: req.body.participation,
            },
            {
              where: { id: req.params.id },
            }
          )
            .then((_) => {
              Evenement.update(
                {
                  title: req.body.title,
                  lieu: req.body.lieu,
                  date: req.body.date,
                  description: req.body.description,
                  url : req.body.url
                },
                {
                  where: { id: excursion.Evenement.id },
                }
              ).then((_) => {
                excursion.getEvenement().then((evenement) => {
                  evenement
                    .getExcursion()
                    .then((excursion) => {
                      const message =
                        "Modification avec succes de l'excursion.";
                      res.json({
                        message: message,
                        data: {
                          id: excursion.id,
                          title: evenement.title,
                          lieu: evenement.lieu,
                          date: evenement.date,
                          description: evenement.description,
                          url : evenement.url,
                          createdAt: excursion.createdAt,
                          updatedAt: excursion.updatedAt,
                          participation: excursion.participation,
                        },
                      });
                    })
                    .catch((error) => {
                      handleError(error, res);
                    });
                });
              });
            })
            .catch((error) => {
              handleError(error, res);
            });
        } else {
          const message =
            "Tentative de modification d'une excursion non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la modification d'une excursion. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
