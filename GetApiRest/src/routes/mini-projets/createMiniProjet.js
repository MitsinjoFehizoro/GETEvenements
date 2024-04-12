const { ValidationError } = require("sequelize");
const {ConcoursProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.post("/get/mini-projets", (req, res) => {
    ConcoursProjet.findByPk(req.body.concoursProjetId)
      .then((concoursProjet) => {
        if (concoursProjet) {
          concoursProjet
            .createMiniProjet({
              title: req.body.title,
              theme: req.body.theme,
              description: req.body.description,
              image: req.body.image,
            })
            .then((miniProjet) => {
              miniProjet.getConcoursProjet().then((concoursProjet) => {
                concoursProjet.getEvenement().then((evenement) => {
                  const message = "Ajout avec succes d'un mini-projet.";
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
            })
            .catch((error) => {
              if (error instanceof ValidationError) {
                res.status(400).json({ message: error.message });
              } else {
                const message = "Erreur de l'ajout d'un mini-projet.";
                res.status(500).json({ message });
              }
            });
        } else {
          const message =
            "Tentative d'ajout d'un mini-projet pour un concours de projet non trouve. Reessayer avec un autre concoursProjetId valide.";
          res.status(400).json({ message: message });
        }
      })
      .catch((error) => {
        const message =
          "Erreur de l'ajout d'un mini-projet. Reessayer dans quelques instants.";
        res.status(500).json({ message: message });
      });
  });
};
