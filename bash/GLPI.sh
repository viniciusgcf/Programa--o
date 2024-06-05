#!/bin/bash
if glpi-agent --version | grep -q '1.5-1';
then
    echo "GLPI ATUALIZADO"
else
    echo "INSTALANDO o GLPI Agent"
    echo "Qual é a tag do computador?"
    read nome
    sudo apt autoremove

    
    wget https://github.com/glpi-project/glpi-agent/releases/download/1.5/glpi-agent-1.5-x86_64.AppImage
    mv glpi-agent-1.5-x86_64.AppImage glpi.AppImage
    chmod +x glpi.AppImage
    ./glpi.AppImage --reinstall -s http://ti.ararangua.sc.gov.br:10000/glpi/front/inventory.php -t "$nome" --scan-profiles --scan-homedirs
    ~/glpi-agent --force

fi
