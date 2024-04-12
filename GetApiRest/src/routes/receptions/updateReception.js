const { ValidationError } = require("sequelize");
const { Evenement, Reception, Programme } = require("../../db/sequelize");

const handleError = (error, res) => {
  if (error instanceof ValidationError) {
    res.status(400).json({ message: error.message });
  } else {
    const message =
      "Erreur de la modification d'une reception. Reessayer dans quelques instants.";
    res.status(500).json({ message });
  }
};

module.exports = (app) => {
  app.put("/get/receptions/:id", (req, res) => {
    Reception.findByPk(req.params.id, { include: [Evenement, Programme] })
      .then((reception) => {
        if (reception) {
          Reception.update(
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
                  where: { id: reception.Evenement.id },
                }
              ).then((_) => {
                reception.getEvenement().then(async (evenement) => {
                  await evenement
                    .getReception()
                    .then(async (reception1) => {
                      const message =
                        "Modification avec succes de l'excursion.";
                      await res.json({
                        message: message,
                        data: {
                          id: reception1.id,
                          title: evenement.title,
                          lieu: evenement.lieu,
                          date: evenement.date,
                          description: evenement.description,
                          url : evenement.url,
                          createdAt: reception1.createdAt,
                          updatedAt: reception1.updatedAt,
                          participation: reception1.participation,
                          programmes: reception.Programmes,
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
