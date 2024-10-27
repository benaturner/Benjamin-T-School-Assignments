#include "game.h"
#include "surface.h"
#include <cstdio> //printf
#include <fstream>
#include <string>
using namespace std;

namespace Tmpl8
{
	static Sprite ocean(new Surface("assets/ocean.tga"), 1);
	static Sprite letters(new Surface("assets/letters.tga"), 1);
	static Sprite numbers(new Surface("assets/numbers.tga"), 1);
	static Sprite carrierHorizontal(new Surface("assets/carrierHorizontal.tga"), 1);
	static Sprite carrierVertical(new Surface("assets/carrierVertical.tga"), 1);
	int carrierX = 0;
	int carrierY = 0;
	bool isCarrierHorizontal = true;
	static Sprite battleshipHorizontal(new Surface("assets/battleshipHorizontal.tga"), 1);
	static Sprite battleshipVertical(new Surface("assets/battleshipVertical.tga"), 1);
	int battleshipX = 0;
	int battleshipY = 0;
	bool isBattleshipHorizontal = true;
	static Sprite cruiserHorizontal(new Surface("assets/cruiserHorizontal.tga"), 1);
	static Sprite cruiserVertical(new Surface("assets/cruiserVertical.tga"), 1);
	int cruiserX = 0;
	int cruiserY = 0;
	bool isCruiserHorizontal = true;
	static Sprite subHorizontal(new Surface("assets/subHorizontal.tga"), 1);
	static Sprite subVertical(new Surface("assets/subVertical.tga"), 1);
	int subX = 0;
	int subY = 0;
	bool isSubHorizontal = true;
	static Sprite destroyerHorizontal(new Surface("assets/destroyerHorizontal.tga"), 1);
	static Sprite destroyerVertical(new Surface("assets/destroyerVertical.tga"), 1);
	int destroyerX = 0;
	int destroyerY = 0;
	bool isDestroyerHorizontal = true;
	ifstream coordinates("coordinates.txt");

	void positionCarrier()
	{
		string line;
		getline(coordinates, line);
		carrierX = stoi(line);
		getline(coordinates, line);
		carrierY = stoi(line);
		getline(coordinates, line);
		if (line == "Y")
			isCarrierHorizontal = true;
		else
			isCarrierHorizontal = false;
	}

	void positionBattleship()
	{
		string line;
		getline(coordinates, line);
		battleshipX = stoi(line);
		getline(coordinates, line);
		battleshipY = stoi(line);
		getline(coordinates, line);
		if (line == "Y")
			isBattleshipHorizontal = true;
		else
			isBattleshipHorizontal = false;
	}

	void positionCruiser()
	{
		string line;
		getline(coordinates, line);
		cruiserX = stoi(line);
		getline(coordinates, line);
		cruiserY = stoi(line);
		getline(coordinates, line);
		if (line == "Y")
			isCruiserHorizontal = true;
		else
			isCruiserHorizontal = false;
	}

	void positionSub()
	{
		string line;
		getline(coordinates, line);
		subX = stoi(line);
		getline(coordinates, line);
		subY = stoi(line);
		getline(coordinates, line);
		if (line == "Y")
			isSubHorizontal = true;
		else
			isSubHorizontal = false;
	}

	void positionDestroyer()
	{
		string line;
		getline(coordinates, line);
		destroyerX = stoi(line);
		getline(coordinates, line);
		destroyerY = stoi(line);
		getline(coordinates, line);
		if (line == "Y")
			isDestroyerHorizontal = true;
		else
			isDestroyerHorizontal = false;
	}
	// -----------------------------------------------------------
	// Initialize the application
	// -----------------------------------------------------------
	void Game::Init()
	{
		positionCarrier();
		positionBattleship();
		positionCruiser();
		positionSub();
		positionDestroyer();
	}
	
	// -----------------------------------------------------------
	// Close down application
	// -----------------------------------------------------------
	void Game::Shutdown()
	{
	}

	// static Sprite rotatingGun(new Surface("assets/aagun.tga"), 36);

	static int frame = 0;

	// -----------------------------------------------------------
	// Main application tick function
	// -----------------------------------------------------------
	void Game::Tick(float deltaTime)
	{
		// clear the graphics window
		screen->Clear(0);
		// print something in the graphics window
		screen->Print("hello world", 2, 2, 0xffffff);
		// print something to the text window
		printf("this goes to the console window.\n");
		// draw a sprite
		ocean.SetFrame(0);
		ocean.Draw(screen, 0, 0);
		letters.Draw(screen, 40, 0);
		numbers.Draw(screen, 0, 40);
		if (isCarrierHorizontal)
			carrierHorizontal.Draw(screen, carrierX, carrierY);
		else
			carrierVertical.Draw(screen, carrierX, carrierY);
		if (isBattleshipHorizontal)
			battleshipHorizontal.Draw(screen, battleshipX, battleshipY);
		else
			battleshipVertical.Draw(screen, battleshipX, battleshipY);
		if (isCruiserHorizontal)
			cruiserHorizontal.Draw(screen, cruiserX, cruiserY);
		else
			cruiserVertical.Draw(screen, cruiserX, cruiserY);
		if (isSubHorizontal)
			subHorizontal.Draw(screen, subX, subY);
		else
			subVertical.Draw(screen, subX, subY);
		if (isDestroyerHorizontal)
			destroyerHorizontal.Draw(screen, destroyerX, destroyerY);
		else
			destroyerVertical.Draw(screen, destroyerX, destroyerY);
		if (++frame == 36) frame = 0;
	}
}