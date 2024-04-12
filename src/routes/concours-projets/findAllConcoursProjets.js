const { Evenement, ConcoursProjet, MiniProjet } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/concours-projets/", (req, res) => {
    ConcoursProjet.findAll({ include: [Evenement, MiniProjet] })
      .then((concoursprojets) => {
        const message =
          "Recuperation avec succes de tous les concours de projet.";
        const data = concoursprojets.map((concoursProjet) => ({
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
        }));
        res.json({
          message: message,
          data: data,
        });
      })
      .catch((error) => {
        const message =
          "Erreur de la recuperation de toutes les concours de projet. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
