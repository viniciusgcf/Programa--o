<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Transporte</title>
</head>
<body>
    <h2>Viagens</h2>

    <a href="{{ route('login.index') }}">Login</a>

    @can('create_user')
    <a href="">Criar usuario</a>
    @endcan

    @can('create_post')
    <a href="">Criar post</a>
    @endcan

    <hr>

    <ul>@foreach ($users as $user)
        <li>{{$user->name}}</li>
    @endforeach</ul>
</body>
</html>
socoro vai se fude
