module.exports = (app) => {
  app.get("/", (req, res) => {
    const message = "Bienvenue dans l'api du GET.";
    res.json({ message });
  });
};
