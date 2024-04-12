const { MiniProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/mini-projets", (req, res) => {
    const data = [];
    MiniProjet.findAll()
      .then(async (miniProjets) => {
        for (const miniProjet of miniProjets) {
          await miniProjet.getConcoursProjet().then(async (concoursProjet) => {
            await concoursProjet.getEvenement().then((evenement) => {
              data.push({
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
              });
            });
          });
        }
        const message = "Recuperation avec succes de tous les mini-projets.";
        res.json({
          message: message,
          data: data,
        });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de tous les mini-projets. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
