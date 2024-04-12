const { Evenement, ConcoursProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/concours-projets/:id", (req, res) => {
    ConcoursProjet.findByPk(req.params.id, { include: Evenement })
      .then((concoursProjet) => {
        if (concoursProjet) {
          ConcoursProjet.destroy({ where: { id: req.params.id } }).then((_) => {
            Evenement.destroy({
              where: { id: concoursProjet.EvenementId },
            })
              .then((_) => {
                const message =
                  "Suppression avec succes d'un concours de projet.";
                res.json({
                  message: message,
                  data: {
                    id: concoursProjet.id,
                    title: concoursProjet.Evenement.title,
                    lieu: concoursProjet.Evenement.lieu,
                    date: concoursProjet.Evenement.date,
                    description: concoursProjet.Evenement.description,
                    url : concoursProjet.Evenement.url,
                    createdAt: concoursProjet.date,
                    updatedAt: concoursProjet.updatedAt,
                    jurry: concoursProjet.jurry,
                  },
                });
              })
              .catch((error) => {
                const message =
                  "Erreur de la suppression d'un concours de projet. Reessayer dans quelques instants.";
                res.status(500).json({ message });
              });
          });
        } else {
          const message =
            "Tentative de suppression d'un concours de projet non trouve.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'un concours de projet. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
