const { Evenement, Excursion } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/excursions/:id", (req, res) => {
    Excursion.findByPk(req.params.id, { include: Evenement })
      .then((excursion) => {
        if (excursion) {
          Excursion.destroy({ where: { id: req.params.id } })
            .then((_) => {
              Evenement.destroy({
                where: { id: excursion.EvenementId },
              })
                .then((_) => {
                  const message = "Suppression avec succes d'une excursion";
                  res.json({
                    message: message,
                    data: {
                      id: excursion.id,
                      title: excursion.Evenement.title,
                      lieu: excursion.Evenement.lieu,
                      date: excursion.Evenement.date,
                      description: excursion.Evenement.description,
                      url : excursion.Evenement.url,
                      createdAt: excursion.date,
                      updatedAt: excursion.updatedAt,
                      participation: excursion.participation,
                    }
                  });
                })
                .catch((error) => {
                  const message =
                    "Erreur de la suppression d'une excursion. Reessayer dans quelques instants.";
                  res.status(500).json({ message });
                });
            })
            .catch((error) => {
              const message =
                "Erreur de la suppression d'une excursion. Reessayer dans quelques instants.";
              res.status(500).json({ message });
            });
        } else {
          const message =
            "Tentative de suppression d'une excursion non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'une excursion. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
