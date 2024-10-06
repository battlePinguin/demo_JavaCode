##тесты пока что в техдолге)##

Напишите приложение, которое по REST принимает запрос вида

POST api/v1/wallet
{
walletId: UUID,
operationType: DEPOSIT or WITHDRAW,
amount: 1000
} 

После выполнять логику по изменению счета в базе данных
также есть возможность получить баланс кошелька

GET api/v1/wallets/{WALLET_UUID}

стек:
java 8-17
Spring 3
Postgresql

Должны быть написаны миграции для базы данных с помощью liquibase
Обратите особое внимание проблемам при работе в конкурентной среде (1000 RPS по
одному кошельку). Ни один запрос не должен быть не обработан (50Х error)
Предусмотрите соблюдение формата ответа для заведомо неверных запросов, когда
кошелька не существует, не валидный json, или недостаточно средств.
приложение должно запускаться в докер контейнере, база данных тоже, вся система
должна подниматься с помощью docker-compose
предусмотрите возможность настраивать различные параметры как на стороне
приложения так и базы данных без пересборки контейнеров.
эндпоинты должны быть покрыты тестами.
