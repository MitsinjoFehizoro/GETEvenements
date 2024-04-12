const { Evenement, Conference } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/conferences/:id", (req, res) => {
    Conference.findByPk(req.params.id)
      .then((conference) => {
        if (conference) {
          conference.getEvenement().then((evenement) => {
            const message = "Recuperation avec succes d'une conference.";
            res.json({
              message: message,
              data: {
                id: conference.id,
                title: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                description: evenement.description,
                url : evenement.url,
                createdAt: conference.createdAt,
                updatedAt: conference.updatedAt,
                intervenant: conference.intervenant,
                cible: conference.cible,
              },
            });
          });
        } else {
          const message =
            "Conference non trouvee. Veuillez verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'une conference. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
