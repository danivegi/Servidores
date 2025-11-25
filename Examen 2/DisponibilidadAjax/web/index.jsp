<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Disponibilidad AJAX</title>

    <script>
        function comprobar() {
            let login = document.getElementById("login").value;

            let xhr = new XMLHttpRequest();
            xhr.open("GET", "compruebaDisponibilidadXML.jsp?login=" + encodeURIComponent(login), true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    procesarXML(xhr.responseXML);
                }
            };
            xhr.send(null);
        }

        function procesarXML(xml) {
            let disponible = xml.getElementsByTagName("disponible")[0].textContent;
            let divResultado = document.getElementById("resultado");

            if (disponible === "si") {
                divResultado.innerHTML = `<span style="color:green">Nombre disponible ?</span>`;
            } else {
                let alternativas = xml.getElementsByTagName("login");
                let lista = "<p style='color:red'>No disponible ?</p><ul>";

                for (let i = 0; i < alternativas.length; i++) {
                    let alt = alternativas[i].textContent;
                    // Cada alternativa es un enlace clicable
                    lista += `<li><a href="#" onclick="usar('${alt}')">${alt}</a></li>`;
                }

                lista += "</ul>";
                divResultado.innerHTML = lista;
            }
        }

        function usar(valor) {
            document.getElementById("login").value = valor;
        }
    </script>
</head>

<body>
<h2>Comprobar disponibilidad (AJAX)</h2>

<label>Nombre de usuario:</label>
<input type="text" id="login" onkeyup="comprobar()">

<div id="resultado"></div>

</body>
</html>
