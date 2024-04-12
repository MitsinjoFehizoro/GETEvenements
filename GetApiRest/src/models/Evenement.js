module.exports = (sequelize, DataTypes) => {
  return sequelize.define(
    "Evenement",
    {
      id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      title: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
          notEmpty: { msg: "Le titre de l'evenement ne peut pas etre vide." },
          notNull: { msg: "Le titre est une propriete requise." },
        },
      },
      lieu: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
          notEmpty: { msg: "Le lieu de l'evenement ne peut pas etre vide." },
          notNull: { msg: "Le lieu est une propriete requise." },
        },
      },
      date: {
        type: DataTypes.DATE,
        allowNull: false,
        validate: {
          notNull: { msg: "La date est une propriete requise." },
          isDate: { msg: "Le format de la date est invalide." },
        },
      },
      url : {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
          notEmpty: {
            msg: "L'url de l'image de l'evenement ne peut pas etre vide.",
          },
          notNull: { msg: "L'url de l'image est une propriete requise." },
        },
      },
      description: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
          notEmpty: {
            msg: "La description de l'evenement ne peut pas etre vide.",
          },
          notNull: { msg: "La desciption est une propriete requise." },
        },
      },
    },
    {
      timestamps: true,
      createdAt: true,
      updatedAt: true,
    }
  );
};
