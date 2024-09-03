<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePermissionsRolesTable extends Migration
{
    /**
     * Run the migrations.
     */
    public function up() : void
    {
        Schema::create('permissions_roles', function (Blueprint $table) {
            $table->id();
            $table->timestamps();

            $table->bigInteger('permission_id')->unsigned();
            $table->foreign('permission_id')
                ->references('id')
                ->on('permissions')->onDelete('cascade');

            $table->bigInteger('role_id')->unsigned();
            $table->foreign('role_id')
                ->references('id')
                ->on('roles')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down() : void
    {
        Schema::dropIfExists('permissions_roles');
    }
}
;
