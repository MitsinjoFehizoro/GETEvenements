module.exports = (sequelize, DataTypes) => {
  return sequelize.define("Programme", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    description: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: {
          msg: "La description du programme ne peut pas etre vide.",
        },
        notNull: {
          msg: "La desciption du programme est une propriete requise.",
        },
      },
    },
    debut: {
      type: DataTypes.TIME,
      allowNull: false,
      validate: {
        notNull: {
          msg: "L'heure de debut d'un programme est une propriete requise",
        },
        isValidTime(value) {
          const timeRegex = /^([01]\d|2[0-3]):([0-5]\d):([0-5]\d)$/;
          if (!timeRegex.test(value)) {
            throw new Error(
              "Le format de l'heure est invalide. Utilisez le format HH:MM:SS."
            );
          }
        },
      },
    },
    fin: {
      type: DataTypes.TIME,
      allowNull: false,
      validate: {
        notNull: {
          msg: "L'heure de fin d'un programme est une propriete requise",
        },
        isValidTime(value) {
          const timeRegex = /^([01]\d|2[0-3]):([0-5]\d):([0-5]\d)$/;
          if (!timeRegex.test(value)) {
            throw new Error(
              "Le format de l'heure est invalide. Utilisez le format HH:MM:SS."
            );
          }
        },
      },
    },
  });
};
