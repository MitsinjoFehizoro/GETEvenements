module.exports = (sequelize, DataTypes) => {
  return sequelize.define("Excursion", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    participation: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "La participation ne peut pas etre vide.",
        notNull: "La participation est une propriete requise.",
      },
    },
  });
};
