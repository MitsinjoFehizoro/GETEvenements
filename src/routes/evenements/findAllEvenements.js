const { Evenement } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/evenements", (req, res) => {
    Evenement.findAll().then((evenements) => {
      const data = evenements.map((evenement) => evenement);
      const message = "Recuperation avec succes de tous les evenements";
      res.json({
        message: message,
        data: data,
      });
    })
    .catch(error=>{
        const message =
          "Erreur de la recuperation de tous les evenements. Reessayer dans quelques instants.";
        res.status(500).json({ message });
    })
  });
};
