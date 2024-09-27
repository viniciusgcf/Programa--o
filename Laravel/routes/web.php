<?php

use App\Http\Controllers\HomeController;
use App\Http\Controllers\LoginController;
use Illuminate\Support\Facades\Route;
use App\Models\User;

Route::get('/', function () {

    Auth::loginUsingId(1);

    $users = User::all();

    return view('welcome', ['users' => $users]);
});

Route::get('/login', function () {

    var_dump('login view');
})->middleware('can:login_page');

Route::get('/', [HomeController::class, 'index']);

Route::controller(LoginController::class)->group(function () {
    Route::get('/login', 'index')->name('login.index');
    Route::post('/login', 'store')->name('login.store');
    Route::get('/logout', 'destroy')->name('login.destroy');
});
