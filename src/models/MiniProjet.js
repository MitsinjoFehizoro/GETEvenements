module.exports = (sequelize, DataTypes) => {
  return sequelize.define("MiniProjet", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    title: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "Le titre du mini-proget ne peut pas etre vide.",
        notNull: "Le titre est une propriete requise.",
      },
    },
    theme: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "Le theme du mini-proget ne peut pas etre vide.",
        notNull: "Le theme est une propriete requise.",
      },
    },
    description: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "La description du mini-proget ne peut pas etre vide.",
        notNull: "La description est une propriete requise.",
      },
    },
    image: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "L'image du mini-proget ne peut pas etre vide.",
        notNull: "L'image est une propriete requise.",
      },
    },
    vote_public: {
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: 0,
    },
  });
};
