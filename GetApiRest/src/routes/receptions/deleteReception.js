const { Evenement, Reception } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/receptions/:id", (req, res) => {
    Reception.findByPk(req.params.id, { include: Evenement })
      .then((reception) => {
        if (reception) {
          Reception.destroy({ where: { id: req.params.id } })
            .then((_) => {
              Evenement.destroy({
                where: { id: reception.EvenementId },
              })
                .then((_) => {
                  const message = "Suppression avec succes d'une reception.";
                  res.json({
                    message: message,
                    data: {
                      id: reception.id,
                      title: reception.Evenement.title,
                      lieu: reception.Evenement.lieu,
                      date: reception.Evenement.date,
                      description: reception.Evenement.description,
                      url : reception.Evenement.url,
                      createdAt: reception.date,
                      updatedAt: reception.updatedAt,
                      participation: reception.participation,
                    },
                  });
                })
                .catch((error) => {
                  const message =
                    "Erreur de la suppression d'une reception. Reessayer dans quelques instants.";
                  res.status(500).json({ message });
                });
            })
            .catch((error) => {
              const message =
                "Erreur de la suppression d'une reception. Reessayer dans quelques instants.";
              res.status(500).json({ message });
            });
        } else {
          const message =
            "Tentative de suppression d'une reception non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'une reception. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
