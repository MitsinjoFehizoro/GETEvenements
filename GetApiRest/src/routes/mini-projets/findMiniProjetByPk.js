const { MiniProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/mini-projets/:id", (req, res) => {
    MiniProjet.findByPk(req.params.id)
      .then((miniProjet) => {
        if (miniProjet) {
          miniProjet.getConcoursProjet().then((concoursProjet) => {
            concoursProjet.getEvenement().then((evenement) => {
              const message = "Recuperation avec succes d'un mini-projet.";
              const data = {
                id: miniProjet.id,
                title: miniProjet.title,
                theme: miniProjet.theme,
                description: miniProjet.description,
                image: miniProjet.image,
                vote_public: miniProjet.vote_public,
                concoursProjet: evenement.title,
                lieu: evenement.lieu,
                date: evenement.date,
                jurry: concoursProjet.jurry,
                createdAt: miniProjet.createdAt,
                updatedAt: miniProjet.updatedAt,
              };
              res.json({ message: message, data: data });
            });
          });
        } else {
          const message =
            "Mini-projet non trouve. Veuillez verifier votre URL.";
          res.status(404).json({ message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation d'un mini-projet. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
