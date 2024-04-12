const { Evenement, ConcoursProjet } = require("../../db/sequelize");

const handleError = (error, res) => {
  if (error instanceof ValidationError) {
    res.status(400).json({ message: error.message });
  } else {
    const message =
      "Erreur de la modification d'un concours projet. Reessayer dans quelques instants.";
    res.status(500).json({ message });
  }
};

module.exports = (app) => {
  app.put("/get/concours-projets/:id", (req, res) => {
    ConcoursProjet.findByPk(req.params.id, { include: Evenement })
      .then((concoursProjet) => {
        if (concoursProjet) {
          ConcoursProjet.update(
            {
              jurry: req.body.jurry,
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
                  url : req.body.url,
                  description: req.body.description,
                },
                {
                  where: { id: concoursProjet.Evenement.id },
                }
              ).then((_) => {
                concoursProjet
                  .getEvenement()
                  .then((evenement) => {
                    evenement.getConcoursProjet().then((concoursProjet) => {
                      const message =
                        "Modification avec succes du concours projet.";
                      res.json({
                        message: message,
                        data: {
                          id: concoursProjet.id,
                          title: evenement.title,
                          lieu: evenement.lieu,
                          date: evenement.title,
                          description: evenement.description,
                          url : evenement.url,
                          createdAt: concoursProjet.createdAt,
                          updatedAt: concoursProjet.updatedAt,
                          jurry: concoursProjet.jurry,
                        },
                      });
                    });
                  })
                  .catch((error) => {
                    handleError(error, res);
                  });
              });
            })
            .catch((error) => {
              handleError(error, res);
            });
        } else {
          const message =
            "Tentative de modification d'un concours de projet non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la modification d'un concours de projet. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
