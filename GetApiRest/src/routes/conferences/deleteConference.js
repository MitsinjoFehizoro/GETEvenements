const { Evenement, Conference } = require("../../db/sequelize");

module.exports = (app) => {
  app.delete("/get/conferences/:id", (req, res) => {
    Conference.findByPk(req.params.id, {include : Evenement})
      .then((conference) => {
        if (conference) {
          Conference.destroy({ where: { id: req.params.id } })
            .then((_) => {
              const message = "Suppression avec succes d'une conference.";
              res.json({
                message: message,
                data: {
                  id: conference.id,
                  title: conference.Evenement.title,
                  lieu: conference.Evenement.lieu,
                  date: conference.Evenement.date,
                  description: conference.Evenement.description,
                  url : conference.Evenement.url,
                  createdAt: conference.createdAt,
                  updatedAt: conference.updatedAt,
                  intervenant: conference.intervenant,
                  cible: conference.cible,
                },
              });
            })
            .catch((error) => {
              const message =
                "Erreur de la supression d'une conference. Reessayer dans quelques instants.";
              res.status(400).json({ message });
            });
        } else {
          const message =
            "Tentative de supression d'une conference non trouvee.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la suppression d'une conference. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
