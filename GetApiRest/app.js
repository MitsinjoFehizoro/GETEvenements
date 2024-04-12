const express = require("express");
const bodyParser = require("body-parser");
const sequelize = require("./src/db/sequelize");

const app = express();

app.use(bodyParser.json());

sequelize.initDb();

//Tous les points de terminaison
require("./src/routes/principal")(app);

require("./src/routes/evenements/findAllEvenements")(app);
require("./src/routes/evenements/findEvenementByPk")(app);

require("./src/routes/conferences/findConferenceByPk")(app);
require("./src/routes/conferences/findAllConferences")(app);
require("./src/routes/conferences/createConference")(app);
require("./src/routes/conferences/updateConference")(app);
require("./src/routes/conferences/deleteConference")(app);

require("./src/routes/concours-projets/findConcoursProjetByPk")(app);
require("./src/routes/concours-projets/findAllConcoursProjets")(app);
require("./src/routes/concours-projets/createConcoursProjet")(app);
require("./src/routes/concours-projets/updateConcoursProjet")(app);
require("./src/routes/concours-projets/deleteConcoursProjet")(app);

require("./src/routes/mini-projets/findMiniProjetByPk")(app);
require("./src/routes/mini-projets/findAllMiniProjets")(app);
require("./src/routes/mini-projets/createMiniProjet")(app);
//mbola mila ampiana resaka etudiants

require("./src/routes/excursions/findExcursionByPk")(app);
require("./src/routes/excursions/findAllExcursions")(app);
require("./src/routes/excursions/createExcursions")(app);
require("./src/routes/excursions/updateExcursion")(app);
require("./src/routes/excursions/deleteExcursion")(app);

require("./src/routes/activites/findActiviteByPk")(app);
require("./src/routes/activites/findAllActivites")(app);
require("./src/routes/activites/createActivite")(app);
require("./src/routes/activites/updateActivite")(app);
require("./src/routes/activites/deleteActivite")(app);

require("./src/routes/receptions/findReceptionByPk")(app);
require("./src/routes/receptions/fiindAllReceptions")(app);
require("./src/routes/receptions/createReceptions")(app);
require("./src/routes/receptions/updateReception")(app);
require("./src/routes/receptions/deleteReception")(app);

require("./src/routes/programmes/findProgrammeByPk")(app);
require("./src/routes/programmes/findAllProgrammes")(app);
require("./src/routes/programmes/createProgramme")(app);
require("./src/routes/programmes/updateProgramme")(app);
require("./src/routes/programmes/deleteProgramme")(app);

//Gestion des erreurs 404
app.use(({ res }) => {
  const message = "Erreur : 404. Ressource non trouvee !!";
  res.status(404).json({ message });
});

const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Notre application est lancee sur le port ${port}`);
});
