const { Sequelize, DataTypes } = require("sequelize");
const EvenementModel = require("../models/Evenement");
const ConferenceModel = require("../models/Conference");
const ConcoursProjetModel = require("../models/ConcoursProjet");
const MiniProjetModel = require("../models/MiniProjet");
const ExcursionModel = require("../models/Excursion");
const ActiviteModel = require("../models/Activite");
const ReceptionModel = require("../models/Reception");
const ProgrammeModel = require("../models/Programme");
const EVENEMENTS = require("./constant/EVENEMENTS");
const CONFERENCES = require("./constant/CONFERENCES");
const CONCOURSPROJET = require("./constant/CONCOURSPROJET");
const MINIPROJETS = require("./constant/MINIPROJETS");
const EXCURSION = require("./constant/EXCURSION");
const ACTIVITES = require("./constant/ACTIVITES");
const RECEPTION = require("./constant/RECEPTION");
const PROGRAMMES = require("./constant/PROGRAMMES");

const sequelize = new Sequelize("get", "root", "", {
  host: "localhost",
  dialect: "mariadb",
  dialectOptions: {
    timezone: "Etc/GMT-2",
  },
  logging: false,
});

sequelize
  .authenticate()
  .then((_) => {
    console.log("Reussite de la connexion a la base de donnees.");
  })
  .catch((error) => {
    console.error(`Echec de la connexion a la base de donnees : ${error}`);
  });

// sequelize
//   .sync({ force: true })
//   .then((_) => {
//     console.log("Reussite de la syncronisation de la base de donnees.");
//   })
//   .catch((error) => {
//     console.error(
//       `Echec de la syncronisation de la base de donnees : ${error}`
//     );
//   });

//Instanciation des models
const Evenement = EvenementModel(sequelize, DataTypes);
const Conference = ConferenceModel(sequelize, DataTypes);
const ConcoursProjet = ConcoursProjetModel(sequelize, DataTypes);
const MiniProjet = MiniProjetModel(sequelize, DataTypes);
const Excursion = ExcursionModel(sequelize, DataTypes);
const Activite = ActiviteModel(sequelize, DataTypes);
const Reception = ReceptionModel(sequelize, DataTypes);
const Programme = ProgrammeModel(sequelize, DataTypes);

//Relation entre les models
Evenement.hasOne(Conference, { onDelete: "CASCADE" });
Conference.belongsTo(Evenement, { onDelete: "CASCADE" });

Evenement.hasOne(ConcoursProjet, { onDelete: "CASCADE" });
ConcoursProjet.belongsTo(Evenement, { onDelete: "CASCADE" });

ConcoursProjet.hasMany(MiniProjet, { onDelete: "CASCADE" });
MiniProjet.belongsTo(ConcoursProjet);

Evenement.hasOne(Excursion, { onDelete: "CASCADE" });
Excursion.belongsTo(Evenement, { onDelete: "CASCADE" });

Excursion.hasMany(Activite, { onDelete: "CASCADE" });
Activite.belongsTo(Excursion);

Evenement.hasOne(Reception, { onDelete: "CASCADE" });
Reception.belongsTo(Evenement, { onDelete: "CASCADE" });

Reception.hasMany(Programme, { onDelete: "CASCADE" });
Programme.belongsTo(Reception);

const initDb = () => {
  sequelize
    .sync({ force: true })
    .then((_) => {
      //Creation conferences
      for (let i = 0; i < 3; i++) {
        const evenement = Evenement.create({
          title: EVENEMENTS[i].title,
          lieu: EVENEMENTS[i].lieu,
          date: EVENEMENTS[i].date,
          description: EVENEMENTS[i].description,
          url: EVENEMENTS[i].url,
        }).then((evenement) => {
          evenement.createConference({
            intervenant: CONFERENCES[i].intervenant,
            cible: CONFERENCES[i].cible,
          });
        });
      }

      //Creation concours projet
      const evenement = Evenement.create({
        title: EVENEMENTS[3].title,
        lieu: EVENEMENTS[3].lieu,
        date: EVENEMENTS[3].date,
        description: EVENEMENTS[3].description,
        url: EVENEMENTS[3].url,
      }).then((evenement) => {
        evenement
          .createConcoursProjet({
            jurry: CONCOURSPROJET.jurry,
          })
          .then((concours) => {
            MINIPROJETS.map((miniprojet) => {
              MiniProjet.create({
                title: miniprojet.title,
                theme: miniprojet.theme,
                description: miniprojet.description,
                image: miniprojet.image,
                vote_public: miniprojet.vote_public,
                ConcoursProjetId: concours.id,
              });
            });
          });
      });

      //Creation d'une excursion
      Evenement.create({
        title: EVENEMENTS[4].title,
        lieu: EVENEMENTS[4].lieu,
        date: EVENEMENTS[4].date,
        description: EVENEMENTS[4].description,
        url: EVENEMENTS[4].url,
      }).then((evenement) => {
        evenement
          .createExcursion({
            participation: EXCURSION.participation,
          })
          .then((excursion) => {
            ACTIVITES.map((activite) => {
              Activite.create({
                title: activite.title,
                description: activite.description,
                ExcursionId: excursion.id,
              });
            });
          });
      });

      //Creation d'une reception
      Evenement.create({
        title: EVENEMENTS[5].title,
        lieu: EVENEMENTS[5].lieu,
        date: EVENEMENTS[5].date,
        description: EVENEMENTS[5].description,
        url: EVENEMENTS[5].url,
      }).then((evenement) => {
        evenement
          .createReception({
            participation: RECEPTION.participation,
          })
          .then((reception) => {
            PROGRAMMES.map((programme) => {
              Programme.create({
                title: programme.title,
                description : programme.description,
                debut: programme.debut,
                fin: programme.fin,
                ReceptionId: reception.id,
              });
            });
          });
      });

      console.log("Reussite de l'ajout dans la bdd.");
    })
    .catch((error) => {
      console.error(`Erreur de l'ajout dans la bdd ${error}.`);
    });
};

module.exports = {
  Evenement,
  Conference,
  ConcoursProjet,
  MiniProjet,
  Excursion,
  Activite,
  Reception,
  Programme,
  initDb,
};
