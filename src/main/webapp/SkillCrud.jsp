<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une compétence</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        #successAlert {
            position: fixed;
            top: 20%;
            left: 50%;
            transform: translateX(-50%);
            z-index: 1050;
            display: none; /* Cachée par défaut */
        }
        .container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="alert alert-success" role="alert" id="successAlert"
         style="display: none;">
        <% if (request.getAttribute("message") != null) { %>
        <%= request.getAttribute("message") %>
        <% } %>
    </div>

    <h2>Ajouter une compétence</h2>
    <form action="SkillServlet" method="POST">
        <div class="form-group">
            <label for="name">Nom de la competence:</label>
            <input type="text" class="form-control" id="name" name="name"
                   required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description"
                      rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="domain">Domaine:</label>
            <input type="text" class="form-control" id="domain" name="domain"
                   required>
        </div>
        <div class="form-group">
            <label for="level">Niveau:</label>
            <select class="form-control" id="level" name="level" required>
                <option value="">Sélectionnez un niveau</option>
                <option value="Débutant">Débutant</option>
                <option value="Intermédiaire">Intermédiaire</option>
                <option value="Avancé">Avancé</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {

        <% if (request.getAttribute("message") != null) { %>
        // Affiche l'alerte
        $('#successAlert').show();
        // Masque l'alerte après 2 secondes (2000 millisecondes)
        setTimeout(function() {
            $('#successAlert').fadeOut('slow');
        }, 2000); // 2 secondes
        <% } %>
    });
</script>
</body>
</html>
