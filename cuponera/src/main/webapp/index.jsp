
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>La cuponera</title>
<link rel="stylesheet" href="css/bootstrap1.min.css">
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<div id="login">
		<h1 class="text-center text-white pt-5">LA CUPONERA</h1>
		<hr>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="logControler" method="post">
							<h3 class="text-center text-dark">Login</h3>
							<div class="form-group">
								<label for="usuarioLogin" class="text-dark font-weight-bold">Usuario:</label><br>
								<input type="text" name="usuarioLogin" id="usuarioLogin" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="contraLogin" class="text-dark font-weight-bold">Contraseña:</label><br>
								<input type="password" name="contraLogin" id="contraLogin" class="formcontrol" required>
							</div>
							<div class="form-group">
								<input type="submit" name="operacion"
									class="btn btn-info btn-md" value="logueo"> <input
									type="hidden" name="operacion" value="logueo">
							</div>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>