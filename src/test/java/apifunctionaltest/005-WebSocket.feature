# Author: anand.ramkumar@experionglobal.com
@runonlythis
Feature: WebSocket Messaging Demo

  # Background setup for WebSocket scenarios
  Background:
    * configure ssl = true

  # Objective: Connect to WebSocket at 'wss://echo.websocket.org/' and send messages.

  # Scenario: Send and receive multiple text messages
  Scenario: Multiple Text Messages
    * def socket = karate.webSocket('wss://echo.websocket.org/')

    
    * socket.send('Message 1')
    * listen 5000
    * print 'Received Response 1: ', listenResult

    * socket.send('Message 2')
    * listen 5000
    * print 'Received Response 2: ', listenResult

    * socket.send('Message 3')
    * listen 5000
    * print 'Received Response 3: ', listenResult