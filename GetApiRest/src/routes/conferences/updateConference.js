const { ValidationError } = require("sequelize");
const { Evenement, Conference } = require("../../db/sequelize");

const handleError = (error, res) => {
  if (error instanceof ValidationError) {
    res.status(400).json({ message: error.message });
  } else {
    const message =
      "Erreur de la modification d'une conference. Reessayer dans quelques instants.";
    res.status(500).json({ message });
  }
};

module.exports = (app) => {
  app.put("/get/conferences/:id", (req, res) => {
    Conference.findByPk(req.params.id, { include: Evenement })
      .then((conference) => {
        if (conference) {
          Conference.update(
            {
              intervenant: req.body.intervenant,
              cible: req.body.cible,
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
                  where: { id: conference.Evenement.id },
                }
              )
                .then((_) => {
                  conference.getEvenement().then((evenement) => {
                    evenement.getConference().then((conference) => {
                      const message =
                        "Modification avec succes de la conference.";
                      res.json({
                        message: message,
                        data: {
                          id: conference.id,
                          title: evenement.title,
                          lieu: evenement.lieu,
                          date: evenement.date,
                          url : evenement.url,
                          description: evenement.description,
                          createdAt: conference.createdAt,
                          updatedAt: conference.updatedAt,
                          intervenant: conference.intervenant,
                          cible: conference.cible,
                        },
                      });
                    });
                  });
                })
                .catch((error) => {
                  handleError(error, res);
                });
            })
            .catch((error) => {
              handleError(error, res);
            });
        } else {
          const message =
            "Tentative de modification d'une conference non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la modification d'une conference. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
