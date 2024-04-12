const { Evenement, ConcoursProjet, MiniProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/concours-projets/:id", (req, res) => {
    ConcoursProjet.findByPk(req.params.id, {
      include: [Evenement, MiniProjet],
    })
      .then((concoursProjet) => {
        if (concoursProjet) {
          const message =
            "Recuperation avec succes d'un concours de mini-projet.";
          res.json({
            message: message,
            data: {
              id: concoursProjet.id,
              title: concoursProjet.Evenement.title,
              lieu: concoursProjet.Evenement.lieu,
              date: concoursProjet.Evenement.date,
              description: concoursProjet.Evenement.description,
              url : concoursProjet.Evenement.url,
              createdAt: concoursProjet.createdAt,
              updatedAt: concoursProjet.updatedAt,
              jurry: concoursProjet.jurry,
              miniprojets: concoursProjet.MiniProjets,
            }
          });
        } else {
          const message = "Concours de projet non trouvee. Verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'un concours de projet. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};