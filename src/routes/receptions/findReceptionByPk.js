const { Evenement, Reception, Programme } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/receptions/:id", (req, res) => {
    Reception.findByPk(req.params.id, {
      include: [Evenement, Programme],
    })
      .then((reception) => {
        if (reception) {
          const message = "Recuperation avec succes d'une excursion.";
          res.json({
            message: message,
            data :{
              id : reception.id,
              title : reception.Evenement.title,
              lieu :reception.Evenement.lieu,
              date : reception.Evenement.date,
              description : reception.Evenement.description,
              url : reception.Evenement.url,
              createdAt: reception.createdAt,
              updatedAt: reception.updatedAt,
              participation: reception.participation,
              programmes: reception.Programmes,
            }
          });
        } else {
          const message = "Reception non trouvee. Verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'une reception. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
