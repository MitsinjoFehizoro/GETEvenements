const { Evenement } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/evenements/:id", (req, res) => {
    Evenement.findByPk(req.params.id)
      .then((evenement) => {
        if (evenement) {
          const message = "Recuperation avec success d'un evenement.";
          res.json({
            message: message,
            data: evenement,
          });
        } else {
          const message = "Evenement non trouve. Veuillez verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'un evenement. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
