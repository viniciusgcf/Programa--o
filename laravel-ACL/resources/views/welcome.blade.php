<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Laravel ACL</title>
</head>
<body>
<h2>Laravel ACL</h2>
<a href="">Create User</a>
<a href="">Create Post</a>
<ul>
@foreach ($users as $user)
<li>{{$user->name}}</li>
@endforeach
</ul>
</body>
</html>
