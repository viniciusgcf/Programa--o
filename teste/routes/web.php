<?php

use Illuminate\Support\Facades\Route;
use App\Models\User;

Route::get('/', function () {

    Auth::loginUsingId(2);

    $users = User::all();

    return view('welcome', ['users' => $users]);
});

Route::get('/user/create', function () {

    return view('user_create');
});

Route::get('/login', function () {

    var_dump('login view');
})->middleware('can:login_page');
